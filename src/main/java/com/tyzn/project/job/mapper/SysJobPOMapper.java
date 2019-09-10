package com.tyzn.project.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.job.pojo.SysJobPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 定时任务Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-09
 */
@Mapper
public interface SysJobPOMapper extends BaseMapper<SysJobPO>
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
     * 删除定时任务
     * 
     * @param jobid 定时任务ID
     * @return 结果
     */
    public int deleteSysJobPOById(Long jobid);

    /**
     * 批量删除定时任务
     * 
     * @param jobids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysJobPOByIds(String[] jobids);
}
