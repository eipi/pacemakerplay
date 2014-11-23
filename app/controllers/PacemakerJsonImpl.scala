package controllers

import models.User
import parsers.JsonParser._
import play.mvc.{Controller, Result}
import views.html.defaultpages.notFound
import play.mvc.Http.Status.OK


/**
 * Created by dbdon_000 on 21/11/2014.
 */
class PacemakerJsonImpl extends Controller {

  def users: Result = {
    val users: java.util.List[User] = User.findAll
    return ok(renderEntity(users))
  }

  def user(id: Long): Result = {
    val user: User = User.findById(id)
    return if (user == null) notFound else ok(renderEntity(user))
  }

  def createUser: Result = {
    val user: User = buildUser(request.body.asJson.toString)
    user.save
    return ok(renderEntity(user))
  }

  def deleteUser(id: Long): Result = {
    var result: Result = notFound
    val user: User = User.findById(id)
    if (user != null) {
      user.delete
      result = ok
    }
    return result
  }

  def deleteAllUsers: Result = {
    User.deleteAll
    return ok
  }

  def updateUser(userJson: String): Result = {
    val searchUser: User = buildUser(
    //request.body.asJson.toString
    userJson
  )
    var result: Result = notFound
    val user: User = User.findById(searchUser.id)
    if (user != null) {
      val updatedUser: User = searchUser
      user.update(updatedUser)
      user.save
      result = ok(renderEntity(user))
    }
    return result
  }
}