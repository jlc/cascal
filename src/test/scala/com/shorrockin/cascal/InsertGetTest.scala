package com.shorrockin.cascal

import org.junit.{Assert, Test}
import com.shorrockin.cascal.utils.Utils

class InsertGetTest extends CassandraTestPool {
  import com.shorrockin.cascal.utils.Conversions._
  import Assert._

  @Test def testInsertGet = borrow { session =>

    val col = "Test" \ "Standard" \ "Test" \ "col name"
    assertTrue(session.get(col).isEmpty)
    
    session.insert(col \ "col value")
    assertEquals("col value", string(session.get(col).get.value))
  }

}