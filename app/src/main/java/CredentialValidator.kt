class CredentialValidator {
    companion object {
        fun isEmptyEmailAddress(emailAddress: String?): Boolean {
            return emailAddress.isNullOrBlank()
        }

        fun isValidEmailAddress(emailAddress: String?): Boolean {
            if (emailAddress.isNullOrEmpty()) return false

            val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
            return emailAddress.matches(emailRegex)
        }

        fun isEmptyPassword(password: String?): Boolean {
            return password.isNullOrBlank()
        }
    }
}
