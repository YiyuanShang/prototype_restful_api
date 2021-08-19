package com.athensoft.edusys.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.athensoft.edusys.admin.entity.AdminEntry;
import com.athensoft.edusys.admin.entity.AdminEntryId;
import com.athensoft.edusys.admin.entity.AdminStatus;

public interface AdminEntryRepository extends JpaRepository<AdminEntry, AdminEntryId>{
	List<AdminEntry> findAllByGroup_groupId(Integer groupId);
	
	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query(value = "INSERT INTO admin_rel_group_admin (emp_id, comment, admin_status, group_id) VALUES(:empId, :comment, :adminStatus, :groupId) ", nativeQuery = true)
	int createAdminEntry(@Param("empId") Integer empId,
						@Param("comment") String comment,
						@Param("adminStatus") Integer adminStatus,
						@Param("groupId") Integer groupId);
	
	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query(value = "DELETE FROM admin_rel_group_admin WHERE emp_id = :empId AND group_id = :groupId ", nativeQuery = true)
	int deleteAdminEntry(@Param("empId") Integer empId, @Param("groupId") Integer groupId);

}
