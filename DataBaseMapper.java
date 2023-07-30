package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.*;

public interface DataBaseMapper {
    /**
     * 备份
     */
    int BackupEmployee();
    int BackupPosition();
    int BackupDepartment();
    int BackupNation();
    int BackupJobLevel();
    int BackupPoliticsStatus();
    int BackupAppraise();
    int BackupAdjustSalary();
    int BackupEmployeeec();
    int BackupEmployeeRemove();
    int BackupEmployeeTrain();
    int BackupEmpSalary();
    int BackupSalary();
    int BackupMenu();
    int BackupRole();
    int BackupHr();
    int BackupMsgContent();
    int BackupFlywaySchemaHistory();
    int BackupMailSendLog();
    int BackupMenuRole();
    int BackupHrRole();
    int BackupOplog();
    int BackupSysMsg();
    /**
     * 恢复
     */
    int RecoverEmployee();
    int RecoverPosition();
    int RecoverDepartment();
    int RecoverNation();
    int RecoverJobLevel();
    int RecoverPoliticsStatus();
    int RecoverAppraise();
    int RecoverAdjustSalary();
    int RecoverEmployeeec();
    int RecoverEmployeeRemove();
    int RecoverEmployeeTrain();
    int RecoverEmpSalary();
    int RecoverSalary();
    int RecoverMenu();
    int RecoverRole();
    int RecoverHr();
    int RecoverMsgContent();
    int RecoverFlywaySchemaHistory();
    int RecoverMailSendLog();
    int RecoverMenuRole();
    int RecoverHrRole();
    int RecoverOplog();
    int RecoverSysMsg();
    int maxWorkID();

}
