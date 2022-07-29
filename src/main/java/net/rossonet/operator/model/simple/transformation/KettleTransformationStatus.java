package net.rossonet.operator.model.simple.transformation;

import java.util.ArrayList;
import java.util.List;

public class KettleTransformationStatus {

	public enum ReturnCode {
		CODE0("The transformation ran without a problem"), CODE1("Errors occurred during processing"),
		CODE2("An unexpected error occurred during loading / running of the transformation"),
		CODE3("Unable to prepare and initialize this transformation"),
		CODE7("The transformation couldn't be loaded from XML or the Repository"),
		CODE8("Error loading steps or plugins (error in loading one of the plugins mostly)"),
		CODE9("Command line usage printing");

		private final String message;

		ReturnCode(final String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

	private List<String> messages = new ArrayList<>();
	private Integer returnCode = null;

	private String returnCodeDescription = "INIT";

	public List<String> getMessages() {
		return messages;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public String getReturnCodeDescription() {
		return returnCodeDescription;
	}

	public void setMessages(final List<String> messages) {
		this.messages = messages;
	}

	public void setReturnCode(final Integer returnCode) {
		this.returnCode = returnCode;
	}

	public void setReturnCodeDescription(final String returnCodeDescription) {
		this.returnCodeDescription = returnCodeDescription;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("KettleTransformationStatus [");
		if (messages != null) {
			builder.append("messages=");
			builder.append(messages);
			builder.append(", ");
		}
		if (returnCode != null) {
			builder.append("returnCode=");
			builder.append(returnCode);
			builder.append(", ");
		}
		if (returnCodeDescription != null) {
			builder.append("returnCodeDescription=");
			builder.append(returnCodeDescription);
		}
		builder.append("]");
		return builder.toString();
	}

}
