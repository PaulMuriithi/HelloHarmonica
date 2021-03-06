import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.ReferenceOption

object Users : IntIdTable("users") {
    val name = varchar("name", length = 60)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
}

object Animals : IntIdTable("animals") {

    val user = reference("userId", Users, onDelete = ReferenceOption.CASCADE)
    val name = varchar("name", length = 60)
}

class Animal(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Animal>(Animals)

    var user by User referencedOn Animals.user
    var name by Animals.name
}