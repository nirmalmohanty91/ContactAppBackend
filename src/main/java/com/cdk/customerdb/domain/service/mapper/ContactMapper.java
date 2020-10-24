package com.cdk.customerdb.domain.service.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.cdk.customerdb.model.Contact;

@Mapper
@Component
public interface ContactMapper {

  final String getAll = "SELECT * FROM people";
  final String getByName = "SELECT * from people where fname=#{firstName}";
  final String insertRecord =
      "INSERT into people(id,fname,lname,address) VALUES(#{id}, #{fname}, #{lname}, #{address})";
  final String deleteRecordByID = "DELETE from people WHERE id = #{id}";

  @Select(getAll)
  List<Contact> getAll();

  @Select(getByName)
  Contact getByName(String firstName);

  @Insert(insertRecord)
  void insertRecord(Contact contact);

  @Delete(deleteRecordByID)
  boolean deleteRecordByID(String id);

}
