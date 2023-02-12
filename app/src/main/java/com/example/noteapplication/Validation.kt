package com.example.noteapplication


    fun isValidEmail(email: String): Boolean {
        return email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}".toRegex())
    }
    fun isValidName(name: String):Boolean{
        return name.matches("[a-zA-Zа-яёА-ЯЁ]{3,255}".toRegex())
    }
    fun isValidPassword(password:String):Boolean{
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,50}\$".toRegex())
    }
