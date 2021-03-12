package com.example.taskerapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.ListFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskerapp.R
import com.example.taskerapp.model.Task
import com.example.taskerapp.viewmodel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : BottomSheetDialogFragment() {
    private lateinit var mTaskViewModel: TaskViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mTaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }


    private fun insertDataToDatabase() {
        val nameOfTask = addEditTextNameOfTask.text.toString()
        val descriptionOfTask = addEditTextDescriptionOfTask.text.toString()
        val deadline = addEditTextDeadlineOfTask.text.toString()

        if (inputCheck(nameOfTask, descriptionOfTask, deadline)) {
            // Create User Object
            val user = Task(0, nameOfTask, descriptionOfTask, deadline)
            // Add Data to Database
            mTaskViewModel.addTask(user)
//            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            val listFragment = ListFragment()
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, listFragment)
                .commit()
            this.dismiss()
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun inputCheck(
        nameOfTask: String,
        descriptionOfTask: String,
        deadlineOfTask: String
    ): Boolean {
        return !(TextUtils.isEmpty(nameOfTask) && TextUtils.isEmpty(descriptionOfTask) && TextUtils.isEmpty(
            deadlineOfTask
        ))
    }


}