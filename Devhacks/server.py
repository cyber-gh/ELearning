from flask import Flask, request, jsonify, send_from_directory
import cloudhelp as gwa
import subprocess
import os

bucket_name = "voice-tunes"
number_of_words_per_chunk = 7

app = Flask(__name__, static_url_path='')

@app.route('/generate', methods = ['POST'])
def request_generate_srt():
    content = request.get_json()

    url = content['url']

    gwa.get_audio_from_youtube_url(url)
    blob_name = gwa.upload_blob(bucket_name)

    blob_uri = f"gs://{bucket_name}/{blob_name}"

    gwa.get_words_timestamps_from_video_uri(blob_uri)
    srt_id = gwa.generate_srt("./output/output.txt", number_of_words_per_chunk)

    gwa.cleanup()

    return jsonify(data=srt_id)

@app.route('/srt', methods = ['POST'])
def request_get_srt():
    content = request.get_json()

    id = content['id']

    print (f'Getting {id}.srt file...')

    f = open(f"./srts/{id}.srt", "r")
    srt_content = f.read()
    f.close()
    
    res = srt_content.replace('\n', '\\n')
    ret = jsonify(data=res)
    return ret

def root_dir():
    return "./videos"

@app.route('/video')
def get_resource():
    return send_from_directory(root_dir(), "./video_1.mp4")

@app.route('/srt_file')
def get_srtt():
    return send_from_directory('./srts', 'dd66fe49-1097-493c-bd7a-1edcbc55560a.srt')

if __name__ == '__main__':
    app.run(host = '0.0.0.0', port = 3000, threaded = False)