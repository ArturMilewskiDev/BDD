package com.example.cucumberplayground.steps

import com.example.cucumberplayground.steps.models.User
import io.cucumber.core.api.TypeRegistry
import io.cucumber.core.api.TypeRegistryConfigurer
import io.cucumber.datatable.DataTableType
import io.cucumber.datatable.TableEntryTransformer
import java.util.*

/** It needs to be located inside a package defined in the glue option. */
@SuppressWarnings("unused")
class CustomTypeRegistryConfigurer : TypeRegistryConfigurer {

    override fun configureTypeRegistry(registry: TypeRegistry) {
        registry.defineDataTableType(User::class.java) {
                entry -> getUser(entry)
        }
    }

    override fun locale(): Locale {
        return Locale.ENGLISH
    }

    private fun <T> TypeRegistry.defineDataTableType(type: Class<T>, tableEntryTransformer: TableEntryTransformer<T>) {
        defineDataTableType(DataTableType(type, tableEntryTransformer))
    }

    private fun getUser(dataTableMap: Map<String, String?>) = User(
        dataTableMap["name"]!!,
        dataTableMap["surname"]!!,
        dataTableMap["premiumAccount"].toBoolean(),
        dataTableMap["age"]!!.toInt(),
        dataTableMap["additionalInformation"]!!,
    )
}
