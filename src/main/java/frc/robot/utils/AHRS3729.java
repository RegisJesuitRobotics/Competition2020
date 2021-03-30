// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/** Add your docs here. */
public class AHRS3729 extends AHRS {
    @Override
	public void initSendable(SendableBuilder builder) {
		builder.setSmartDashboardType("Gyro");
        builder.addDoubleProperty("Value", this::getYaw, null);
        builder.addDoubleProperty("Fused Compass Heading", this::getFusedHeading, null);
        builder.addDoubleProperty("Altitude", this::getAltitude, null);
        builder.addDoubleProperty("Pressure", this::getPressure, null);
    }
}
