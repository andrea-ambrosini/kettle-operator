package net.rossonet.operator.model.cron.transformation;

public class CronKettleTransformationSpec {
	private Integer replicas;
	private Integer version;

	public Integer getReplicas() {
		return replicas;
	}

	public Integer getVersion() {
		return version;
	}

	public void setReplicas(final Integer replicas) {
		this.replicas = replicas;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

}
