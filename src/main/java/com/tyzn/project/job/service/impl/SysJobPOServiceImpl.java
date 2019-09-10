package com.tyzn.project.job.service.impl;

import com.common.Utils.DateUtils;
import com.common.core.text.Convert;
import com.tyzn.project.job.core.CronTaskRegistrar;
import com.tyzn.project.job.core.SchedulingRunnable;
import com.tyzn.project.job.mapper.SysJobPOMapper;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务Service业务层处理
 *
 * @author Uncle_liu
 * @date 2019-09-09
 */
@Service
@Transactional
public class SysJobPOServiceImpl implements ISysJobPOService {
    private static final Logger logger = LoggerFactory.getLogger(SysJobPOServiceImpl.class);
    @Autowired
    private SysJobPOMapper sysJobPOMapper;
    @Resource
    private CronTaskRegistrar cronTaskRegistrar; //定时任务注册类

    /**
     * 查询定时任务
     *
     * @param jobid 定时任务ID
     * @return 定时任务
     */
    @Override
    public SysJobPO selectSysJobPOById(Long jobid) {
        return sysJobPOMapper.selectSysJobPOById(jobid);
    }

    /**
     * 查询定时任务列表
     *
     * @param sysJobPO 定时任务
     * @return 定时任务
     */
    @Override
    public List<SysJobPO> selectSysJobPOList(SysJobPO sysJobPO) {
        return sysJobPOMapper.selectSysJobPOList(sysJobPO);
    }

    /**
     * 新增定时任务
     *
     * @param sysJobPO 定时任务
     * @return 结果
     */
    @Override
    public int insertSysJobPO(SysJobPO sysJobPO) {
        sysJobPO.setCreateTime(DateUtils.getTime());
        int i = 0;
        try {
            i = sysJobPOMapper.insertSysJobPO(sysJobPO);
            //添加定时任务
            if (i > 0 && sysJobPO.getJobStatus() == 1) {
                SchedulingRunnable start = new SchedulingRunnable(sysJobPO.getBeanName(), sysJobPO.getStartMethodName(), sysJobPO.getMethodParams(),sysJobPO.getJobid());
                cronTaskRegistrar.addCronTask(start, sysJobPO.getStartCron());

                SchedulingRunnable end = new SchedulingRunnable(sysJobPO.getBeanName(), sysJobPO.getEndMethodName(), sysJobPO.getMethodParams(),sysJobPO.getJobid());
                cronTaskRegistrar.addCronTask(end, sysJobPO.getEndCron());
            }
        } catch (Exception e) {
            e.printStackTrace();
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加定时任务失败，执行回滚");
            return 0;
        }

        return i;
    }

    /**
     * 修改定时任务
     *
     * @param sysJobPO 定时任务
     * @return 结果
     */
    @Override
    public int updateSysJobPO(SysJobPO sysJobPO) {
        sysJobPO.setCreateTime(DateUtils.getTime());
        int i = 0;
        try {
            i = sysJobPOMapper.updateSysJobPO(sysJobPO);
            //定时任务
            if (i > 0 ) {
                //起始-------
                SchedulingRunnable start = new SchedulingRunnable(sysJobPO.getBeanName(), sysJobPO.getStartMethodName(), sysJobPO.getMethodParams(),sysJobPO.getJobid());
                //先移除起始
                cronTaskRegistrar.removeCronTask(start.jobNumber());
                //结束-------
                SchedulingRunnable end = new SchedulingRunnable(sysJobPO.getBeanName(), sysJobPO.getEndMethodName(), sysJobPO.getMethodParams(),sysJobPO.getJobid());
                //先移除结束
                cronTaskRegistrar.removeCronTask(end.jobNumber());
                if(sysJobPO.getJobStatus() == 1){
                    //再添加起始
                    cronTaskRegistrar.addCronTask(start, sysJobPO.getStartCron());
                    //再添加结束
                    cronTaskRegistrar.addCronTask(end, sysJobPO.getEndCron());
                }
            }
        } catch (Exception e) {
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改定时任务失败，执行回滚");
            return 0;
        }

        return i;
    }

    /**
     * 删除定时任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysJobPOByIds(String ids) {
        String[] strings = Convert.toStrArray(ids);
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            try {
                long jobid = Long.parseLong(strings[i]);
                //根据id查询
                SysJobPO sysJobPO = sysJobPOMapper.selectSysJobPOById(jobid);
                //删除信息
                result = result + sysJobPOMapper.deleteSysJobPOById(jobid);
                if (sysJobPO.getJobStatus() == 1) {
                    //删除起始定时任务
                    cronTaskRegistrar.removeCronTask(sysJobPO.jobStartNumber());
                    //删除结束定时任务
                    cronTaskRegistrar.removeCronTask(sysJobPO.jobEndNumber());
                }
            } catch (Exception e) {
                //手动回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                logger.error("删除定时任务失败，执行回滚");
                return 0;
            }
        }
        return result;
    }

    /**
     * 删除定时任务信息
     *
     * @param jobid 定时任务ID
     * @return 结果
     */
    public int deleteSysJobPOById(Long jobid) {
        return sysJobPOMapper.deleteSysJobPOById(jobid);
    }





}
