package com.hariofspades.dagger2advanced.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity(tableName = "result")
public class ResultEntity {

   @PrimaryKey(autoGenerate = true)
   private int id;

   @ColumnInfo(name = "name")
   private String name;

   @ColumnInfo(name = "email")
   private String email;

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("ResultEntity{");
      sb.append("id=").append(id);
      sb.append(", name='").append(name).append('\'');
      sb.append(", email='").append(email).append('\'');
      sb.append('}');
      return sb.toString();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;

      if (!(o instanceof ResultEntity)) return false;

      ResultEntity that = (ResultEntity) o;

      return new EqualsBuilder()
           .append(getId(), that.getId())
           .isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder(17, 37)
           .append(getId())
           .toHashCode();
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
