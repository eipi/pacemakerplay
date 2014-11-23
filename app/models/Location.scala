package models

import javax.persistence.{GeneratedValue, Id, Table, Entity}

/**
 * Created by dbdon_000 on 21/11/2014.
 */
@Entity
@Table(name="Locations")
class Location(var latitude: Double,
               var longitude: Double) {

  @Id
  @GeneratedValue
  var id = null
}
