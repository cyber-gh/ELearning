import google.cloud.speech as speech
import google.cloud.storage as storage
import os
import uuid
import shutil
from flask import jsonify
import unidecode

def get_words_timestamps_from_video_uri(gcs_uri):

    client = speech.SpeechClient()

    audio = speech.RecognitionAudio(uri=gcs_uri)
    config = speech.RecognitionConfig(
        encoding=speech.RecognitionConfig.AudioEncoding.FLAC,
        language_code="ro-RO",
        enable_word_time_offsets=True,
        audio_channel_count=2
    )

    operation = client.long_running_recognize(config=config, audio=audio)

    confidence = []
    output = ""

    print("Waiting for operation to complete...")
    result = operation.result()

    for result in result.results:
        alternative = result.alternatives[0]
        confidence.append(alternative.confidence)

        for word_info in alternative.words:
            word = unidecode.unidecode(word_info.word)
            start_time = word_info.start_time
            end_time = word_info.end_time

            output += f"{word} {start_time.total_seconds()} {end_time.total_seconds()}\n"

    print ("Confidence: " + str(sum(confidence) / len(confidence)))
    
    f = open('./output/output.txt', 'w')
    f.write(output)
    f.close()

def upload_blob(bucket_name, source_folder = "output"):
    storage_client = storage.Client()
    bucket = storage_client.bucket(bucket_name)

    source_file_name = os.listdir(source_folder)[0]
    destination_blob_name = source_file_name

    blob = bucket.blob(destination_blob_name)
    blob.upload_from_filename(f".\\{source_folder}\\{source_file_name}")

    print(
        "File uploaded to Cloud Storage"
    )

    return destination_blob_name

def get_audio_from_youtube_url(url):
    os.system("youtube-dl.exe " + url + " -x --audio-format flac --audio-quality 0 -o .\output\\temp_file.%(ext)s")

def cleanup():
    print ('Cleaning output folder')
    shutil.rmtree('./output/')

def generate_srt(input, nr_of_words_per_chunk):
    f = open(input, "r")

    chunks = []
    chunk = []
    for line in f:
        if len(chunk) == nr_of_words_per_chunk:
            chunks.append(chunk.copy())
            chunk.clear()
        
        clean_line = line.split('\n')[0] # remove garbage
        chunk.append(clean_line)
        
    if len(chunk) > 0:
        chunks.append(chunk)
    
    f.close()

    srt_content = ""
    for idx, val in enumerate(chunks):
        min_time = get_time_format(float(val[0].split(' ')[1])) # take the first timestamp from first word in chunk
        max_time = get_time_format(float(val[-1].split(' ')[2])) # the the second timestamp from last word in chunk

        srt_content += f"{idx + 1}\n"
        srt_content += f"{min_time} --> {max_time}\n"
        srt_content += " ".join([x.split(' ')[0] for x in val])
        srt_content += "\n\n"

    id = str(uuid.uuid4())
    g = open(f"./srts/{id}.srt", "w")
    g.write(srt_content)
    g.close()

    print (f"./srts/{id}.srt file was generated!")
    return id

def get_time_format(seconds):
    h = int(seconds) // 3600
    m = int(seconds) // 60
    s = int(seconds) % 60
    mili = int((seconds - int(seconds)) * 1000)

    return f"{h:02}:{m:02}:{s:02},{mili:03}"

def implicit():
    from google.cloud import storage

    # If you don't specify credentials when constructing the client, the
    # client library will look for credentials in the environment.
    storage_client = storage.Client()

    # Make an authenticated API request
    buckets = list(storage_client.list_buckets())
    print(buckets)