package models

import java.util
import javax.persistence._
import com.google.common.base.Objects
import com.google.gson.Gson
import play.db.ebean._


/**
 * Created by dbdon_000 on 21/11/2014.
 */
@Entity
@Table(name="Users")
class User(var firstName: String,
           var lastName: String,
           var email: String,
           var password: String) extends Model {
  @Id
  @GeneratedValue
  var id = null

  var activities : List[Long] = List[Long]()

  def update(user: User) {
    this.firstName = user.firstName
    this.lastName = user.lastName
    this.email = user.email
    this.password = user.password
  }

  override def toString: String = {
    return new Gson().toJson(this)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[User]) {
      val other: User = obj.asInstanceOf[User]
      return Objects.equal(firstName, other.firstName) && Objects.equal(lastName, other.lastName) && Objects.equal(email, other.email)
    }
    else {
      return false
    }
  }
}
object User {

  var find: Model.Finder[String, User] = new Model.Finder[String, User](classOf[String], classOf[User])

  def findAll() : util.List[User] = {
    return find.all()
  }

  def findByEmail(email: String): User = {
    return find.where.eq("email", email).findUnique
  }

  def findById(id: Long): User = {
    return find.where.eq("id", id).findUnique
  }

  def deleteAll {
    import scala.collection.JavaConversions._
    for (user <- find.all) {
      user.delete
    }
  }
}
