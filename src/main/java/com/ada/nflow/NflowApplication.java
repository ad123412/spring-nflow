package com.ada.nflow;

import com.ada.nflow.workflow.ExampleWorkflow;
import io.nflow.engine.config.EngineConfiguration;
import io.nflow.engine.service.WorkflowInstanceService;
import io.nflow.engine.workflow.instance.WorkflowInstanceFactory;
//import io.nflow.rest.config.RestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;

@SpringBootApplication
//@Import(RestConfiguration.class)
@Import(EngineConfiguration.class)
public class NflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(NflowApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertExampleWorkflow() {
        workflowInstances.insertWorkflowInstance(workflowInstanceFactory.newWorkflowInstanceBuilder()
                .setType(ExampleWorkflow.TYPE)
                .setExternalId("example")
                .putStateVariable(ExampleWorkflow.VAR_COUNTER, 0)
                .build());
    }

    @Autowired
    private WorkflowInstanceService workflowInstances;

    @Autowired
    private WorkflowInstanceFactory workflowInstanceFactory;
}


