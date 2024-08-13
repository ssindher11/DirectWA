package com.ssindher.directwa.utils

import org.junit.Test
import org.junit.Assert.*

class UtilsTest {
    @Test
    fun `extractPhoneNumber when no area code is present`() {
        val input = "1234567890"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals(null, countryCode)
        assertEquals("1234567890", phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when area code is present`() {
        val input = "+911234567890"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals("91", countryCode)
        assertEquals("1234567890", phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when area code is present with brackets`() {
        val input = "+91 (123) 456 7890"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals("91", countryCode)
        assertEquals("1234567890", phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when area code is present with hyphens`() {
        val input = "+91-123-456-7890"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals("91", countryCode)
        assertEquals("1234567890", phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when area code is present with spaces (US format)`() {
        val input = "+91 123 456 7890"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals("91", countryCode)
        assertEquals("1234567890", phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when area code is present with spaces (Indian format)`() {
        val input = "+91 12345 67890"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals("91", countryCode)
        assertEquals("1234567890", phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when invalid number is present returns null`() {
        val input = "+91 (123) 456"
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals(null, countryCode)
        assertEquals(null, phoneNumber)
    }

    @Test
    fun `extractPhoneNumber when number is present in a sentence`() {
        val input = "Call me at +91 (987) 654-3210."
        val (countryCode, phoneNumber) = Utils.extractPhoneNumber(input)
        assertEquals("91", countryCode)
        assertEquals("9876543210", phoneNumber)
    }
}