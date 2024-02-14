package pl.klub.bokserski;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class WzrostCallback implements JavaDelegate {
	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService =
		execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("callbackMsg1")
		.processInstanceId(execution.getVariable("parentBussinesKey").toString())
		.setVariable("grupa", execution.getVariable("grupa"))
		.correlateWithResult();}
		}