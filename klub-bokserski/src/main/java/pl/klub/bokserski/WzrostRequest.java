package pl.klub.bokserski;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class WzrostRequest implements JavaDelegate {
	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		Map<String, Object> processVariables = new HashMap<String, Object>();
		processVariables.put("parentBussinesKey", execution.getProcessInstanceId());
		processVariables.put("wzrost", execution.getVariable("wzrost"));
		processVariables.put("kategoria", execution.getVariable("kategoria"));
		runtimeService.startProcessInstanceByMessage("requestMsg1", processVariables);
	}
}