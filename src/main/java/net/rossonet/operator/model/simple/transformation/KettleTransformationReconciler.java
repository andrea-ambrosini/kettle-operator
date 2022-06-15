package net.rossonet.operator.model.simple.transformation;

import java.util.logging.Logger;

import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import io.javaoperatorsdk.operator.api.reconciler.dependent.Dependent;
import net.rossonet.operator.model.StaticUtils;

@ControllerConfiguration(dependents = { @Dependent(type = SimpleTransformationResource.class) })
public class KettleTransformationReconciler implements Reconciler<KettleTransformation> {
	public static final String SELECTOR = "app.kubernetes.io/managed-by=kettle-operator";

	private static final Logger logger = Logger.getLogger(KettleTransformationReconciler.class.getName());

	private final KubernetesClient kubernetesClient;

	public KettleTransformationReconciler() {
		this(new DefaultKubernetesClient());
	}

	public KettleTransformationReconciler(final KubernetesClient kubernetesClient) {
		this.kubernetesClient = kubernetesClient;
	}

	@Override
	public UpdateControl<KettleTransformation> reconcile(final KettleTransformation resource,
			final Context<KettleTransformation> context) throws Exception {
		logger.info("reconciler  " + resource + " -> " + context);
		final String name = context.getSecondaryResource(Job.class).get().getMetadata().getName();
		resource.setStatus(StaticUtils.createKettleTransformationStatus(name));
		return UpdateControl.patchStatus(resource);
	}

}
