package com.example.androiddevchallenge.data.model

data class Dog(
  val id: String,
  val name: String,
  val breed: String,
  val age: Int,
  val sex: Sex,
  val color: String,
  val image: Image,
  val weight: Int = (1..5).random(),
  val description: String = prepareDescription(name, sex)
) {

  enum class Sex(val value: String) {
    MALE("Male"),
    FEMALE("Female")
  }

  data class Image(
    val url: String,
    val width: Int,
    val height: Int
  ) {

    val aspectRatio: Float
      get() = width.toFloat().div(height.toFloat())

  }

  val ageString: String
    get() {
      val ageInYears = (age / 12).toFloat()
      return if (ageInYears <= 0) "$age months"
      else "${ageInYears.toInt()} years"
    }

}

private fun prepareDescription(name: String, sex: Dog.Sex): String {
  val pronoun = if (sex == Dog.Sex.MALE) "He" else "She"
  return "$name is extremely playful, active and funny. $pronoun needs a real family and care, because his " +
      "last owner abandoned him on the streets. $pronoun is shy at first but warms up quickly. Loves to snuggle in bed" +
      "$pronoun is great with kids and little rough with cats but just playing."
}