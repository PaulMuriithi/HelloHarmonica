package db.config

import com.improve_future.harmonica.core.DbConfig
import com.improve_future.harmonica.core.Dbms

object Default : DbConfig({
    dbms = Dbms.PostgreSQL
    dbName = "harmonica_test"
    host = "127.0.0.1"
    user = "developer"
    password = "developer"
})