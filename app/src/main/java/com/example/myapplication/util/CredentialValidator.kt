package com.example.myapplication.util//class CredentialValidator {
//    fun containsNumber(input: String): Boolean {
//        return input.contains("\\d".toRegex())
//    }
//
//    fun containsLetter(input: String): Boolean {
//        return input.contains("[a-zA-Z]".toRegex())
//    }
//
//    fun isEmptyEmailAddress(emailAddress: String?): Boolean {
//        return emailAddress.isNullOrBlank()
//    }
//
//    fun isValidEmailAddress(emailAddress: String?): Boolean {
//        if (emailAddress.isNullOrEmpty()) return false
//
//        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
//        return emailAddress.matches(emailRegex)
//    }
//
//    fun isEmptyPassword(password: String?): Boolean {
//        return password.isNullOrBlank()
//    }
//
//    fun isValidPassword(password: String?): Boolean {
//        if (password.isNullOrEmpty()) return false
//
//        val passwordRegex = "[^a-zA-Z0-9]".toRegex()
//
//        return password.matches(passwordRegex) && containsNumber(password) && containsLetter(password)
//    }
//
//}
