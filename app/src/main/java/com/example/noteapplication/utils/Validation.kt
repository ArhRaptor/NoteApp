package com.example.noteapplication.utils

    const val REGEX_EMAIL = "[A-Za-z\\d._%+-]+@[A-Za-z\\d.-]+\\.[A-Za-z]{2,6}"
    const val REGEX_NAME = "[a-zA-Zа-яёА-ЯЁ]{3,255}"
    const val REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,50}\$"

    fun isValidEmail(email: String): Boolean {
        return email.matches(REGEX_EMAIL.toRegex())
    }
    fun isValidName(name: String):Boolean{
        return name.matches(REGEX_NAME.toRegex())
    }
    fun isValidPassword(password:String):Boolean{
        return password.matches(REGEX_PASSWORD.toRegex())
    }
