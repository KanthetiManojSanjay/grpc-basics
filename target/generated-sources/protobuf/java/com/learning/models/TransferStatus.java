// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transfer-service.proto

package com.learning.models;

/**
 * Protobuf enum {@code TransferStatus}
 */
public enum TransferStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>FAILED = 0;</code>
   */
  FAILED(0),
  /**
   * <code>SUCCESS = 1;</code>
   */
  SUCCESS(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>FAILED = 0;</code>
   */
  public static final int FAILED_VALUE = 0;
  /**
   * <code>SUCCESS = 1;</code>
   */
  public static final int SUCCESS_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static TransferStatus valueOf(int value) {
    return forNumber(value);
  }

  public static TransferStatus forNumber(int value) {
    switch (value) {
      case 0: return FAILED;
      case 1: return SUCCESS;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<TransferStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      TransferStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<TransferStatus>() {
          public TransferStatus findValueByNumber(int number) {
            return TransferStatus.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.learning.models.TransferServiceOuterClass.getDescriptor().getEnumTypes().get(0);
  }

  private static final TransferStatus[] VALUES = values();

  public static TransferStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private TransferStatus(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:TransferStatus)
}

