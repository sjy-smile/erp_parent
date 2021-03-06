package cn.ddossec.service;

import cn.ddossec.common.DataGridView;
import cn.ddossec.domain.LeaveBill;
import cn.ddossec.vo.WorkFlowVo;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author 30315
 * @title: WorkFlowService
 * @projectName erp_parent
 * @description: TODO
 * @date 2020-04-1814:40
 */
public interface WorkFlowService {

    public DataGridView queryProcessDeploy(WorkFlowVo workFlowVo);

    /**
     * 查询所有流程定义
     *
     * @param workFlowVo
     * @return
     */
    DataGridView queryloadAllProcessDefinition(WorkFlowVo workFlowVo);

    /**
     * 添加流程部署
     *
     * @param inputStream
     * @param deploymentName
     */
    void addWorkFlow(InputStream inputStream, String deploymentName);

    /**
     * 根据流程部署ID，删除流程部署信息
     *
     * @param deploymentId
     */
    void deleteWorkFlow(String deploymentId);

    /**
     * 根据流程部署ID查询流程图
     *
     * @param deploymentId
     * @return
     */
    InputStream queryProcessDeploymentImage(String deploymentId);

    /**
     * 启动流程
     *
     * @param leaveBillId
     */
    void startProcess(Integer leaveBillId);

    /**
     * 查询当前登陆人的代办任务
     *
     * @param workFlowVo
     * @return
     */
    DataGridView queryCurrentUserTask(WorkFlowVo workFlowVo);

    /**
     * 根据任务ID查询请假单的信息
     *
     * @param taskId
     * @return
     */
    LeaveBill queryLeaveBillByTaskId(String taskId);

    /**
     * 根据任务ID查询连线信息
     *
     * @param taskId
     * @return
     */
    List<String> queryOutComeByTaskId(String taskId);

    /**
     * @param taskId
     * @return
     */
    DataGridView queryCommentByTaskId(String taskId);

    /**
     * 完成任务
     * @param workFlowVo
     */
    void completeTask(WorkFlowVo workFlowVo);

    /**
     * 根据任务ID，查询流程定义对象
     * @param taskId
     * @return
     */
    ProcessDefinition queryProcessDefinitionByTaskId(String taskId);

    /**
     * 根据任务ID查询节点坐标
     * @param taskId
     * @return
     */
    Map<String, Object> queryTaskCoordinateByTaskId(String taskId);

    /**
     * 根据请假单的ID查询批注信息
     * @param id
     * @return
     */
    DataGridView querydCommentByLeaveBillId(Integer id);
}
