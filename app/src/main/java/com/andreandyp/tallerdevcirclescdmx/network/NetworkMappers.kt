package com.andreandyp.tallerdevcirclescdmx.network

import com.andreandyp.tallerdevcirclescdmx.domain.Country

fun CountryNetwork.asDomain(): Country = Country(
    name = name,
    capitalName = capital,
    population = population,
    area = area,
    flag = flag,
    alpha2Code = alpha2Code,
    alpha3Code = alpha3Code
)