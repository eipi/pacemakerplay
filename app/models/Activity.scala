package models

import java.util.Date
import javax.persistence.{GeneratedValue, Id, Table, Entity}

/**
 * Created by dbdon_000 on 21/11/2014.
 */
@Entity
@Table(name="Activities")
class Activity(var actvType: String,
               var location: String,
               var distance: Double,
               var duration: Double,
               var startTime: Date) {

  @Id
  @GeneratedValue
  var id = null


  var locations : List[Long] = List[Long]()

}