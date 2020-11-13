package dev.skyit.elearning.utility

import com.soywiz.klock.DateTime

val DateTime.dateStr: String
    get() =  "${this.year.year}-${this.month1}-${this.dayOfMonth}"