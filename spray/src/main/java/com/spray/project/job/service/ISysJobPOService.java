package com.spray.project.job.service;


import com.spray.project.job.pojo.SysJobPO;

import java.util.List;

/**
 * 定时任务Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-09
 */
public interface ISysJobPOService 
{
    /**
     * 查询定时任务
     * 
     * @param jobid 定时任务ID
     * @return 定时任务
     */
    public SysJobPO selectSysJobPOById(Long jobid);

    /**
     * 查询定时任务列表
     * 
     * @param sysJobPO 定时任务
     * @return 定时任务集合
     */
    public List<SysJobPO> selectSysJobPOList(SysJobPO sysJobPO);

    /**
     * 新增定时任务
     * 
     * @param sysJobPO 定时任务
     * @return 结果
     */
    public int insertSysJobPO(SysJobPO sysJobPO);

    /**
     * 修改定时任务
     * 
     * @param sysJobPO 定时任务
     * @return 结果
     */
    public int updateSysJobPO(SysJobPO sysJobPO);

    /**
     * 批量删除定时任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysJobPOByIds(String ids);

    /**
     * 删除定时任务信息
     * 
     * @param jobid 定时任务ID
     * @return 结果
     */
    public int deleteSysJobPOById(Long jobid);
}
