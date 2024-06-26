package avn.classvrsdk.sample

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import avn.classvrsdk.sample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ClassVRSDKFragment : Fragment() {
    private val TAG = ClassVRSDKFragment::class.java.name
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called...")
        if (this.activity?.intent?.type.equals("application/x-lifeliqe")) {
            val bmp = BitmapFactory.decodeFile(this.activity?.intent?.data?.encodedPath)
            binding.imageView.setImageBitmap(bmp)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}