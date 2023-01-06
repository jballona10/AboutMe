package com.example.aboutme2023

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to done_button and setOnClickListener
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        // set on click listener on nickname_text text view,
        // pass reference to updateNickname()
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
    }

    /*
    addNickname

    on click listener for the done button that does the following:
    1. Get the text from nickname_edit edit text
    2. Set the text in nickname_text text view
    3. Hide the edit text and button
    4. Display the nickname TextView

    input parameters:
    View: the Done button
     */
    private fun addNickname(view: View) {
        // get reference to nickname_edit edit text and nickname_text view
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // set text in nicknameTextView tv to the user entered info in editText
        nicknameTextView.text = editText.text

        // hide nickname_edit, done_button, and show nicknameTextView
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hide Keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /*
    updateNickname

    on Click listener for the nickname text view that does the following:
    1. Gets reference to nickname_edit edit text and done_button button
    2. Sets visibility of nickname_edit edit text and done_button button to VISIBLE
    3. Sets visibility of nicknameTextView to GONE

    input parameters:
    View: the nickname Text View
     */
    private fun updateNickname (view: View) {
        // get reference to nickname_edit edit text and done_button button
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        // display edit text and done button, hide nickname text view
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        // set focus to edit text
        editText.requestFocus()
        // Show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}