package com.example.androiddevchallenge.data.model

data class Dog(
  val id: String,
  val name: String,
  val breed: String,
  val age: Int,
  val sex: Sex,
  val color: String,
  val image: Image
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