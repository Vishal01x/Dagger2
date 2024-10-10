package com.exa.android.dagger2.Dagger.d.qualifier.customAnnotation

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class SQLDatabaseQualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class NoSQLDatabaseQualifier
