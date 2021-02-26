package com.example.androiddevchallenge.data.repository

import com.example.androiddevchallenge.data.model.Dog

object PuppyRepository {

  val puppies = listOf<Dog>(
    Dog(
      id = "1",
      name = "Nebula",
      breed = "German Shepherd",
      age = 4,
      sex = Dog.Sex.MALE,
      color = "Black, Yellow",
      image = "https://zamroo.s3.ap-south-1.amazonaws.com/images/product-images/pets/pets-for-adoption/medium/20180715125141-3789.jpg"
    ),
    Dog(
      id = "2",
      name = "Naggy",
      breed = "American Staffordshire Terrier",
      age = 6,
      sex = Dog.Sex.FEMALE,
      color = "Black",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657585/1/?bust=1614266611"
    ),
    Dog(
      id = "3",
      name = "Peanut",
      breed = "Chihuahua",
      age = 5,
      sex = Dog.Sex.FEMALE,
      color = "Golden",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657565/1/?bust=1614266505&width=600"
    ),
    Dog(
      id = "4",
      name = "Hector",
      breed = "Jack Russel Terrier",
      age = 12,
      sex = Dog.Sex.MALE,
      color = "White",
      image = "https://qph.fs.quoracdn.net/main-qimg-0716a6c238786dab1ae7bc28dceab389"
    ),
    Dog(
      id = "5",
      name = "Henry",
      breed = "Mixed",
      age = 24,
      sex = Dog.Sex.MALE,
      color = "Apricot / Beige",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657577/1/?bust=1614267041&width=600"
    ),
    Dog(
      id = "6",
      name = "Rosette",
      breed = "Retriever",
      age = 4,
      sex = Dog.Sex.FEMALE,
      color = "Bicolor",
      image = "https://i.pinimg.com/originals/8c/cf/ec/8ccfec7d5cb3c92265cbf153523eb9b5.jpg"
    ),
    Dog(
      id = "7",
      name = "Buster",
      breed = "Dachshund",
      age = 18,
      sex = Dog.Sex.MALE,
      color = "Brown",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657518/3/?bust=1614266304&width=600",
    ),
    Dog(
      id = "8",
      name = "Copper",
      breed = "Beagle",
      age = 6,
      sex = Dog.Sex.MALE,
      color = "Beige",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657462/6/?bust=1614266140&width=600",
    ),
    Dog(
      id = "9",
      name = "Henley",
      breed = "Mixed Shepherd",
      age = 12,
      sex = Dog.Sex.FEMALE,
      color = "Black, Yellow / Tan / Blond / Fawn",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657482/1/?bust=1614266092&width=600",
    ),
    Dog(
      id = "10",
      name = "Whiskey",
      breed = "Labrador Retriever",
      age = 6,
      sex = Dog.Sex.MALE,
      color = "Black, Yellow / Tan / Blond / Fawn",
      image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50657551/1/?bust=1614266887&width=600",
    )
  )

}