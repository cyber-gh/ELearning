package dev.skyit.elearning.student.ui.courses.details

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.kotvertolet.youtubejextractor.YoutubeJExtractor
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.SingleSampleMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.exoplayer2.util.Util
import dev.skyit.elearning.R
import dev.skyit.elearning.databinding.FragmentCourseDetailsBinding
import dev.skyit.elearning.student.StudentActivity
import dev.skyit.elearning.student.ui.generic.BaseFragment
import dev.skyit.elearning.utility.errAlert
import dev.skyit.elearning.utility.snack
import dev.skyit.elearning.utility.toastl
import kotlinx.coroutines.*

class CourseDetailsFragment: BaseFragment(R.layout.fragment_course_details) {

    private val binding: FragmentCourseDetailsBinding by viewBinding()
    private val args: CourseDetailsFragmentArgs by navArgs()

    private lateinit var adapter: CourseDetailsPagerAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skipCourse.isVisible = false;

        adapter = CourseDetailsPagerAdapter(childFragmentManager, args.courseId)
        binding.viewpager.adapter = adapter

        binding.tabLayout.setupWithViewPager(binding.viewpager)

        binding.cotinueLearningBtn.setOnClickListener {
            binding.courseLogo.visibility = View.INVISIBLE
            binding.playerView.visibility = View.VISIBLE

            binding.cotinueLearningBtn.isVisible = false
            binding.textView12.isVisible = false
            binding.textView13.isVisible = false
            binding.skipCourse.isVisible = true;
            configurePlayer()
        }

        binding.skipCourse.setOnClickListener({
            onPause();
            val dialog = TestCourseDialog()
            dialog.show(childFragmentManager, "testCourseDialog")
        })
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

        val handler = CoroutineExceptionHandler { _, exception ->
//            toastl("Please refresh the page")
        }
        GlobalScope.launch(Dispatchers.IO + handler) {
            val extractor = YoutubeJExtractor()
            val data = kotlin.runCatching {
                extractor.extract("A8i4LHFyIlQ")
            }.getOrNull() ?: return@launch //errAlert(getString(R.string.error_load_video))
            withContext(Dispatchers.Main) {

                val srtFile = "http://192.168.1.130:3000/srt_file"
                val videoUri = Uri.parse(data!!.streamingData.muxedStreams.last().url)
                val subtitleUri = Uri.parse(srtFile)
                val player = kotlin.runCatching {   SimpleExoPlayer.Builder(requireContext()).build() }.getOrNull() ?: return@withContext
                binding.playerView.player = player
                playWithCaption(player, videoUri, subtitleUri)

            }
        }

    }

    override fun onPause() {
        super.onPause()
        (activity as? StudentActivity)?.exitFullScreen()
        binding.playerView.player?.stop()
    }

    override fun onResume() {
        super.onResume()
        if (activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            (activity as? StudentActivity)?.enterFullScreen()
        } else {
            (activity as? StudentActivity)?.exitFullScreen()
        }
    }
}


class CourseDetailsPagerAdapter(fm: FragmentManager, private val courseId: String) : FragmentStatePagerAdapter(
    fm,
    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val fragments: List<Fragment> = listOf(
        InfoCourseFragment(),
        CourseReviewsFragment(courseId),
        CourseLessonsFragment(courseId)
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