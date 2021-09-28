// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  private final NetworkTable limelightNetworkTable = NetworkTableInstance.getDefault().getTable("limelight-limeboi");
  private final NetworkTableEntry tx = limelightNetworkTable.getEntry("tx");
  private final NetworkTableEntry ty = limelightNetworkTable.getEntry("ty");
  private final NetworkTableEntry tv = limelightNetworkTable.getEntry("tv");


  public boolean hasValidTarget() {
    return tv.getDouble(0.0) == 1;
  }

  public double getXOffset() {
    return tx.getDouble(0.0);
  }

  public double getYOffset() {
    return ty.getDouble(0.0);
  }
}
