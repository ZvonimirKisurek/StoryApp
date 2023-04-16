package com.example.myquizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia", "Germany", "Armenia",
            1
        )
        questionList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Croatia", "Australia", "Austria", "Armenia",
            2
        )
        questionList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Brazil", "Belize", "Belgium", "Bangladesh",
            3
        )
        questionList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Botswana", "Brazil", "Burkina Faso", "Burundi",
            2
        )
        questionList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominican Republic", "Sweden", "Norway", "Denmark",
            4
        )
        questionList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "France", "Fiji", "Philippines", "Panama",
            2
        )
        questionList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Greenland", "Ghana", "Greece",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Indonesia", "India", "Ireland", "Italy",
            2
        )
        questionList.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kiribati", "Kazakhstan", "North Korea", "Kuwait",
            1
        )
        questionList.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New York", "New Zealand", "Papua New Guinea", "Nigeria",
            2
        )
        questionList.add(que10)


        return questionList

    }

}