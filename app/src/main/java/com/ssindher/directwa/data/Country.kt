package com.ssindher.directwa.data

import androidx.compose.runtime.Immutable

@Immutable
data class Country(
    val name: String,
    val code: String,
    val dialCode: String,
)

val countriesList = listOf(
    Country(name = "Andorra", code = "AD", dialCode = "+376"),
    Country(name = "United Arab Emirates", code = "AE", dialCode = "+971"),
    Country(name = "Afghanistan", code = "AF", dialCode = "+93"),
    Country(name = "Antigua & Barbuda", code = "AG", dialCode = "+1268"),
    Country(name = "Anguilla", code = "AI", dialCode = "+1264"),
    Country(name = "Albania", code = "AL", dialCode = "+355"),
    Country(name = "Armenia", code = "AM", dialCode = "+374"),
    Country(name = "Angola", code = "AO", dialCode = "+244"),
    Country(name = "Antarctica", code = "AQ", dialCode = "+672"),
    Country(name = "Argentina", code = "AR", dialCode = "+54"),
    Country(name = "American Samoa", code = "AS", dialCode = "+1684"),
    Country(name = "Austria", code = "AT", dialCode = "+43"),
    Country(name = "Australia", code = "AU", dialCode = "+61"),
    Country(name = "Aruba", code = "AW", dialCode = "+297"),
    Country(name = "Åland Islands", code = "AX", dialCode = "+358"),
    Country(name = "Azerbaijan", code = "AZ", dialCode = "+994"),
    Country(name = "Bosnia & Herzegovina", code = "BA", dialCode = "+387"),
    Country(name = "Barbados", code = "BB", dialCode = "+1246"),
    Country(name = "Bangladesh", code = "BD", dialCode = "+880"),
    Country(name = "Belgium", code = "BE", dialCode = "+32"),
    Country(name = "Burkina Faso", code = "BF", dialCode = "+226"),
    Country(name = "Bulgaria", code = "BG", dialCode = "+359"),
    Country(name = "Bahrain", code = "BH", dialCode = "+973"),
    Country(name = "Burundi", code = "BI", dialCode = "+257"),
    Country(name = "Benin", code = "BJ", dialCode = "+229"),
    Country(name = "St. Barthélemy", code = "BL", dialCode = "+590"),
    Country(name = "Bermuda", code = "BM", dialCode = "+1441"),
    Country(name = "Brunei", code = "BN", dialCode = "+673"),
    Country(name = "Bolivia", code = "BO", dialCode = "+591"),
    Country(name = "Brazil", code = "BR", dialCode = "+55"),
    Country(name = "Bahamas", code = "BS", dialCode = "+1242"),
    Country(name = "Bhutan", code = "BT", dialCode = "+975"),
    Country(name = "Botswana", code = "BW", dialCode = "+267"),
    Country(name = "Belarus", code = "BY", dialCode = "+375"),
    Country(name = "Belize", code = "BZ", dialCode = "+501"),
    Country(name = "Canada", code = "CA", dialCode = "+1"),
    Country(name = "Cocos (Keeling) Islands", code = "CC", dialCode = "+61"),
    Country(name = "Congo - Kinshasa", code = "CD", dialCode = "+243"),
    Country(name = "Central African Republic", code = "CF", dialCode = "+236"),
    Country(name = "Congo - Brazzaville", code = "CG", dialCode = "+242"),
    Country(name = "Switzerland", code = "CH", dialCode = "+41"),
    Country(name = "Côte d’Ivoire", code = "CI", dialCode = "+225"),
    Country(name = "Cook Islands", code = "CK", dialCode = "+682"),
    Country(name = "Chile", code = "CL", dialCode = "+56"),
    Country(name = "Cameroon", code = "CM", dialCode = "+237"),
    Country(name = "China", code = "CN", dialCode = "+86"),
    Country(name = "Colombia", code = "CO", dialCode = "+57"),
    Country(name = "Costa Rica", code = "CR", dialCode = "+506"),
    Country(name = "Cuba", code = "CU", dialCode = "+53"),
    Country(name = "Cape Verde", code = "CV", dialCode = "+238"),
    Country(name = "Christmas Island", code = "CX", dialCode = "+61"),
    Country(name = "Cyprus", code = "CY", dialCode = "+357"),
    Country(name = "Czechia", code = "CZ", dialCode = "+420"),
    Country(name = "Germany", code = "DE", dialCode = "+49"),
    Country(name = "Djibouti", code = "DJ", dialCode = "+253"),
    Country(name = "Denmark", code = "DK", dialCode = "+45"),
    Country(name = "Dominica", code = "DM", dialCode = "+1767"),
    Country(name = "Dominican Republic", code = "DO", dialCode = "+1849"),
    Country(name = "Algeria", code = "DZ", dialCode = "+213"),
    Country(name = "Ecuador", code = "EC", dialCode = "+593"),
    Country(name = "Estonia", code = "EE", dialCode = "+372"),
    Country(name = "Egypt", code = "EG", dialCode = "+20"),
    Country(name = "Eritrea", code = "ER", dialCode = "+291"),
    Country(name = "Spain", code = "ES", dialCode = "+34"),
    Country(name = "Ethiopia", code = "ET", dialCode = "+251"),
    Country(name = "Finland", code = "FI", dialCode = "+358"),
    Country(name = "Fiji", code = "FJ", dialCode = "+679"),
    Country(name = "Falkland Islands", code = "FK", dialCode = "+500"),
    Country(name = "Micronesia", code = "FM", dialCode = "+691"),
    Country(name = "Faroe Islands", code = "FO", dialCode = "+298"),
    Country(name = "France", code = "FR", dialCode = "+33"),
    Country(name = "Gabon", code = "GA", dialCode = "+241"),
    Country(name = "United Kingdom", code = "GB", dialCode = "+44"),
    Country(name = "Grenada", code = "GD", dialCode = "+1473"),
    Country(name = "Georgia", code = "GE", dialCode = "+995"),
    Country(name = "French Guiana", code = "GF", dialCode = "+594"),
    Country(name = "Guernsey", code = "GG", dialCode = "+44"),
    Country(name = "Ghana", code = "GH", dialCode = "+233"),
    Country(name = "Gibraltar", code = "GI", dialCode = "+350"),
    Country(name = "Greenland", code = "GL", dialCode = "+299"),
    Country(name = "Gambia", code = "GM", dialCode = "+220"),
    Country(name = "Guinea", code = "GN", dialCode = "+224"),
    Country(name = "Guadeloupe", code = "GP", dialCode = "+590"),
    Country(name = "Equatorial Guinea", code = "GQ", dialCode = "+240"),
    Country(name = "Greece", code = "GR", dialCode = "+30"),
    Country(name = "South Georgia & South Sandwich Islands", code = "GS", dialCode = "+500"),
    Country(name = "Guatemala", code = "GT", dialCode = "+502"),
    Country(name = "Guam", code = "GU", dialCode = "+1671"),
    Country(name = "Guinea-Bissau", code = "GW", dialCode = "+245"),
    Country(name = "Guyana", code = "GY", dialCode = "+595"),
    Country(name = "Hong Kong SAR China", code = "HK", dialCode = "+852"),
    Country(name = "Honduras", code = "HN", dialCode = "+504"),
    Country(name = "Croatia", code = "HR", dialCode = "+385"),
    Country(name = "Haiti", code = "HT", dialCode = "+509"),
    Country(name = "Hungary", code = "HU", dialCode = "+36"),
    Country(name = "Indonesia", code = "ID", dialCode = "+62"),
    Country(name = "Ireland", code = "IE", dialCode = "+353"),
    Country(name = "Israel", code = "IL", dialCode = "+972"),
    Country(name = "Isle of Man", code = "IM", dialCode = "+44"),
    Country(name = "India", code = "IN", dialCode = "+91"),
    Country(name = "British Indian Ocean Territory", code = "IO", dialCode = "+246"),
    Country(name = "Iraq", code = "IQ", dialCode = "+964"),
    Country(name = "Iran", code = "IR", dialCode = "+98"),
    Country(name = "Iceland", code = "IS", dialCode = "+354"),
    Country(name = "Italy", code = "IT", dialCode = "+39"),
    Country(name = "Jersey", code = "JE", dialCode = "+44"),
    Country(name = "Jamaica", code = "JM", dialCode = "+1876"),
    Country(name = "Jordan", code = "JO", dialCode = "+962"),
    Country(name = "Japan", code = "JP", dialCode = "+81"),
    Country(name = "Kenya", code = "KE", dialCode = "+254"),
    Country(name = "Kyrgyzstan", code = "KG", dialCode = "+996"),
    Country(name = "Cambodia", code = "KH", dialCode = "+855"),
    Country(name = "Kiribati", code = "KI", dialCode = "+686"),
    Country(name = "Comoros", code = "KM", dialCode = "+269"),
    Country(name = "St. Kitts & Nevis", code = "KN", dialCode = "+1869"),
    Country(name = "North Korea", code = "KP", dialCode = "+850"),
    Country(name = "South Korea", code = "KR", dialCode = "+82"),
    Country(name = "Kuwait", code = "KW", dialCode = "+965"),
    Country(name = "Cayman Islands", code = "KY", dialCode = "+ 345"),
    Country(name = "Kazakhstan", code = "KZ", dialCode = "+77"),
    Country(name = "Laos", code = "LA", dialCode = "+856"),
    Country(name = "Lebanon", code = "LB", dialCode = "+961"),
    Country(name = "St. Lucia", code = "LC", dialCode = "+1758"),
    Country(name = "Liechtenstein", code = "LI", dialCode = "+423"),
    Country(name = "Sri Lanka", code = "LK", dialCode = "+94"),
    Country(name = "Liberia", code = "LR", dialCode = "+231"),
    Country(name = "Lesotho", code = "LS", dialCode = "+266"),
    Country(name = "Lithuania", code = "LT", dialCode = "+370"),
    Country(name = "Luxembourg", code = "LU", dialCode = "+352"),
    Country(name = "Latvia", code = "LV", dialCode = "+371"),
    Country(name = "Libya", code = "LY", dialCode = "+218"),
    Country(name = "Morocco", code = "MA", dialCode = "+212"),
    Country(name = "Monaco", code = "MC", dialCode = "+377"),
    Country(name = "Moldova", code = "MD", dialCode = "+373"),
    Country(name = "Montenegro", code = "ME", dialCode = "+382"),
    Country(name = "St. Martin", code = "MF", dialCode = "+590"),
    Country(name = "Madagascar", code = "MG", dialCode = "+261"),
    Country(name = "Marshall Islands", code = "MH", dialCode = "+692"),
    Country(name = "North Macedonia", code = "MK", dialCode = "+389"),
    Country(name = "Mali", code = "ML", dialCode = "+223"),
    Country(name = "Myanmar (Burma)", code = "MM", dialCode = "+95"),
    Country(name = "Mongolia", code = "MN", dialCode = "+976"),
    Country(name = "Macao SAR China", code = "MO", dialCode = "+853"),
    Country(name = "Northern Mariana Islands", code = "MP", dialCode = "+1670"),
    Country(name = "Martinique", code = "MQ", dialCode = "+596"),
    Country(name = "Mauritania", code = "MR", dialCode = "+222"),
    Country(name = "Montserrat", code = "MS", dialCode = "+1664"),
    Country(name = "Malta", code = "MT", dialCode = "+356"),
    Country(name = "Mauritius", code = "MU", dialCode = "+230"),
    Country(name = "Maldives", code = "MV", dialCode = "+960"),
    Country(name = "Malawi", code = "MW", dialCode = "+265"),
    Country(name = "Mexico", code = "MX", dialCode = "+52"),
    Country(name = "Malaysia", code = "MY", dialCode = "+60"),
    Country(name = "Mozambique", code = "MZ", dialCode = "+258"),
    Country(name = "Namibia", code = "NA", dialCode = "+264"),
    Country(name = "New Caledonia", code = "NC", dialCode = "+687"),
    Country(name = "Niger", code = "NE", dialCode = "+227"),
    Country(name = "Norfolk Island", code = "NF", dialCode = "+672"),
    Country(name = "Nigeria", code = "NG", dialCode = "+234"),
    Country(name = "Nicaragua", code = "NI", dialCode = "+505"),
    Country(name = "Netherlands", code = "NL", dialCode = "+31"),
    Country(name = "Norway", code = "NO", dialCode = "+47"),
    Country(name = "Nepal", code = "NP", dialCode = "+977"),
    Country(name = "Nauru", code = "NR", dialCode = "+674"),
    Country(name = "Niue", code = "NU", dialCode = "+683"),
    Country(name = "New Zealand", code = "NZ", dialCode = "+64"),
    Country(name = "Oman", code = "OM", dialCode = "+968"),
    Country(name = "Panama", code = "PA", dialCode = "+507"),
    Country(name = "Peru", code = "PE", dialCode = "+51"),
    Country(name = "French Polynesia", code = "PF", dialCode = "+689"),
    Country(name = "Papua New Guinea", code = "PG", dialCode = "+675"),
    Country(name = "Philippines", code = "PH", dialCode = "+63"),
    Country(name = "Pakistan", code = "PK", dialCode = "+92"),
    Country(name = "Poland", code = "PL", dialCode = "+48"),
    Country(name = "St. Pierre & Miquelon", code = "PM", dialCode = "+508"),
    Country(name = "Pitcairn Islands", code = "PN", dialCode = "+872"),
    Country(name = "Puerto Rico", code = "PR", dialCode = "+1939"),
    Country(name = "Palestinian Territories", code = "PS", dialCode = "+970"),
    Country(name = "Portugal", code = "PT", dialCode = "+351"),
    Country(name = "Palau", code = "PW", dialCode = "+680"),
    Country(name = "Paraguay", code = "PY", dialCode = "+595"),
    Country(name = "Qatar", code = "QA", dialCode = "+974"),
    Country(name = "Réunion", code = "RE", dialCode = "+262"),
    Country(name = "Romania", code = "RO", dialCode = "+40"),
    Country(name = "Serbia", code = "RS", dialCode = "+381"),
    Country(name = "Russia", code = "RU", dialCode = "+7"),
    Country(name = "Rwanda", code = "RW", dialCode = "+250"),
    Country(name = "Saudi Arabia", code = "SA", dialCode = "+966"),
    Country(name = "Solomon Islands", code = "SB", dialCode = "+677"),
    Country(name = "Seychelles", code = "SC", dialCode = "+248"),
    Country(name = "Sudan", code = "SD", dialCode = "+249"),
    Country(name = "Sweden", code = "SE", dialCode = "+46"),
    Country(name = "Singapore", code = "SG", dialCode = "+65"),
    Country(name = "St. Helena", code = "SH", dialCode = "+290"),
    Country(name = "Slovenia", code = "SI", dialCode = "+386"),
    Country(name = "Svalbard & Jan Mayen", code = "SJ", dialCode = "+47"),
    Country(name = "Slovakia", code = "SK", dialCode = "+421"),
    Country(name = "Sierra Leone", code = "SL", dialCode = "+232"),
    Country(name = "San Marino", code = "SM", dialCode = "+378"),
    Country(name = "Senegal", code = "SN", dialCode = "+221"),
    Country(name = "Somalia", code = "SO", dialCode = "+252"),
    Country(name = "Suriname", code = "SR", dialCode = "+597"),
    Country(name = "South Sudan", code = "SS", dialCode = "+211"),
    Country(name = "São Tomé & Príncipe", code = "ST", dialCode = "+239"),
    Country(name = "El Salvador", code = "SV", dialCode = "+503"),
    Country(name = "Syria", code = "SY", dialCode = "+963"),
    Country(name = "Eswatini", code = "SZ", dialCode = "+268"),
    Country(name = "Turks & Caicos Islands", code = "TC", dialCode = "+1649"),
    Country(name = "Chad", code = "TD", dialCode = "+235"),
    Country(name = "Togo", code = "TG", dialCode = "+228"),
    Country(name = "Thailand", code = "TH", dialCode = "+66"),
    Country(name = "Tajikistan", code = "TJ", dialCode = "+992"),
    Country(name = "Tokelau", code = "TK", dialCode = "+690"),
    Country(name = "Timor-Leste", code = "TL", dialCode = "+670"),
    Country(name = "Turkmenistan", code = "TM", dialCode = "+993"),
    Country(name = "Tunisia", code = "TN", dialCode = "+216"),
    Country(name = "Tonga", code = "TO", dialCode = "+676"),
    Country(name = "Turkey", code = "TR", dialCode = "+90"),
    Country(name = "Trinidad & Tobago", code = "TT", dialCode = "+1868"),
    Country(name = "Tuvalu", code = "TV", dialCode = "+688"),
    Country(name = "Taiwan", code = "TW", dialCode = "+886"),
    Country(name = "Tanzania", code = "TZ", dialCode = "+255"),
    Country(name = "Ukraine", code = "UA", dialCode = "+380"),
    Country(name = "Uganda", code = "UG", dialCode = "+256"),
    Country(name = "United States", code = "US", dialCode = "+1"),
    Country(name = "Uruguay", code = "UY", dialCode = "+598"),
    Country(name = "Uzbekistan", code = "UZ", dialCode = "+998"),
    Country(name = "Vatican City", code = "VA", dialCode = "+379"),
    Country(name = "St. Vincent & Grenadines", code = "VC", dialCode = "+1784"),
    Country(name = "Venezuela", code = "VE", dialCode = "+58"),
    Country(name = "British Virgin Islands", code = "VG", dialCode = "+1284"),
    Country(name = "U.S. Virgin Islands", code = "VI", dialCode = "+1340"),
    Country(name = "Vietnam", code = "VN", dialCode = "+84"),
    Country(name = "Vanuatu", code = "VU", dialCode = "+678"),
    Country(name = "Wallis & Futuna", code = "WF", dialCode = "+681"),
    Country(name = "Samoa", code = "WS", dialCode = "+685"),
    Country(name = "Yemen", code = "YE", dialCode = "+967"),
    Country(name = "Mayotte", code = "YT", dialCode = "+262"),
    Country(name = "South Africa", code = "ZA", dialCode = "+27"),
    Country(name = "Zambia", code = "ZM", dialCode = "+260"),
    Country(name = "Zimbabwe", code = "ZW", dialCode = "+263"),
)