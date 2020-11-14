package dev.skyit.elearning.student.ui.courses.details

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.kotvertolet.youtubejextractor.YoutubeJExtractor
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.SingleSampleMediaSource
import com.google.android.exoplayer2.text.Cue
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.exoplayer2.util.Util
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentCourseDetailsBinding
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.snack
import kotlinx.coroutines.*

class CourseDetailsFragment: BaseFragment(R.layout.fragment_course_details) {

    private val binding: FragmentCourseDetailsBinding by viewBinding()

    private lateinit var adapter: CourseDetailsPagerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = CourseDetailsPagerAdapter(childFragmentManager)
        binding.viewpager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewpager)

        binding.cotinueLearningBtn.setOnClickListener {
            binding.courseLogo.visibility = View.INVISIBLE
            binding.playerView.visibility = View.VISIBLE

            binding.cotinueLearningBtn.isVisible = false
            binding.textView12.isVisible = false
            binding.textView13.isVisible = false
            configurePlayer()
        }
    }

    private fun playWithCaption(player: SimpleExoPlayer, videoUri: Uri, subtitleUri: Uri) {
        val dataSourceFactory = DefaultDataSourceFactory(
            requireContext(),
            Util.getUserAgent(requireContext(), "exo-demo")
        )
        val contentMediaSource: MediaSource = buildMediaSource(videoUri)
        val mediaSources: Array<MediaSource> = arrayOf(MergingMediaSource(), MergingMediaSource())
        mediaSources[0] = contentMediaSource // uri

        //Add subtitles
        val subtitleSource = SingleSampleMediaSource(
            subtitleUri, dataSourceFactory,
            Format.createTextSampleFormat(
                null,
                MimeTypes.APPLICATION_SUBRIP,
                Format.NO_VALUE,
                "en"
            ),
            C.TIME_UNSET
        )
        mediaSources[1] = subtitleSource
        val mediaSource: MediaSource = MergingMediaSource(*mediaSources)

        // Prepare the player with the source.
        //player.seekTo(contentPosition);
        player.prepare(mediaSource)
        player.setPlayWhenReady(true)
    }

    private fun buildMediaSource(parse: Uri): MediaSource {
        val dataSourceFactory = DefaultDataSourceFactory(
            requireContext(),
            Util.getUserAgent(requireContext(), "exo-demo")
        )
        val mediaSource = ExtractorMediaSource(
            parse,
            dataSourceFactory,
            DefaultExtractorsFactory(),
            Handler(),
            null
        )
        return mediaSource
    }


    private fun configurePlayer() {

        GlobalScope.launch(Dispatchers.IO) {
            val extractor = YoutubeJExtractor()
            val data = extractor.extract("3l9jlulT4cQ")
            withContext(Dispatchers.Main) {

//                val meter = DefaultBandwidthMeter()
//                val trackSelector = DefaultTrackSelector(AdaptiveTrackSelection.Factory())
//                val exoPlayer = ExoPlayerFactory.newSimpleInstance(requireContext())
                val srtFile = "http://192.168.1.130:3000/srt_file"
//                val srtFile = "http://192.168.1.155:8000/avatar.srt"
                val videoUri = Uri.parse(data!!.streamingData.muxedStreams.last().url)
                val subtitleUri = Uri.parse(srtFile)
                val player = SimpleExoPlayer.Builder(requireContext()).build()
                binding.playerView.player = player
                playWithCaption(player, videoUri, subtitleUri)


//                lifecycleScope.launch {
//                    while (true) {
//                        delay(500)
//
//                    }
//                }


//                player.setMediaItem(MediaItem.fromUri(videoUri))
//                player.prepare()
//                player.play()
            }
        }




//        val player = SimpleExoPlayer.Builder(requireContext()).build()
//        binding.playerView.player = player
//
//        val media = MediaItem.fromUri(link)
//        player.setMediaItem(media)
//        player.prepare()
//
//        player.play()

    }
}


class CourseDetailsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val fragments: List<Fragment> = listOf(
        InfoCourseFragment(),
        CourseReviewsFragment(),
        CourseLessonsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Info"
            1 -> "Reviews"
            2 -> "Lessons"
            else -> throw IllegalArgumentException("esti pula proasta")
        }
    }
}