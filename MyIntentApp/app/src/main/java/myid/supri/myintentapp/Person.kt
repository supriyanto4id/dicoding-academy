package myid.supri.myintentapp

import android.os.Parcel
import android.os.Parcelable

data class Person(
        val name:String?,
        val age: Int?,
        val email:String?,
        val city :String?
        ) :Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readInt(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(name)
                if (age != null) {
                        parcel.writeInt(age)
                }
                parcel.writeString(email)
                parcel.writeString(city)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Person> {
                override fun createFromParcel(parcel: Parcel): Person {
                        return Person(parcel)
                }

                override fun newArray(size: Int): Array<Person?> {
                        return arrayOfNulls(size)
                }
        }
}
