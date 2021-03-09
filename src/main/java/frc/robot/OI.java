/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Enums.DirectionEnum;
import frc.robot.commands.AutoMoveRotate;
import frc.robot.commands.CommandGroups.IntakeBall;
import frc.robot.commands.CommandGroups.ShootSequence;
import frc.robot.commands.CommandGroups.autoNavChallenge.Slalomn;
import frc.robot.commands.CommandGroups.autoNavChallenge.TestAuto;
import frc.robot.commands.LimelightStuff.LimeLightDriveAlign;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlign;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlignClose;
import frc.robot.commands.ShooterManual.Belt;
import frc.robot.commands.ShooterManual.IntakeDrop;
import frc.robot.commands.ShooterManual.IntakeRun;
//import frc.robot.commands.ShooterManual.IntakeRun;
import frc.robot.commands.ShooterManual.ShooterAim;
import frc.robot.commands.ShooterManual.ShooterShoot;
//import frc.robot.commands.ShooterManual.IntakeDrop;

public class OI {
  // DRIVER CONTROLLER
  Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER);
  Button buttonCircle = new JoystickButton(driverController, 3);
  Button buttonX = new JoystickButton(driverController, 2);
  Button buttonSquare = new JoystickButton(driverController, 1);
  Button buttonTriangle = new JoystickButton(driverController, 4);
  Button buttonLeftBumper = new JoystickButton(driverController, 7);
  Button buttonRightBumper = new JoystickButton(driverController, 8);
  Button touchPad = new JoystickButton(driverController, 14);
  Button buttonOptions = new JoystickButton(driverController, 10);
  Button buttonShare = new JoystickButton(driverController, 9);
  int flag = 0;

  // OPERATOR CONTROLLER
  Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER);
  Button operatorButtonCircle = new JoystickButton(operatorController, 3);
  Button operatorButtonX = new JoystickButton(operatorController, 2);
  Button operatorButtonSquare = new JoystickButton(operatorController, 1);
  Button operatorButtonTriangle = new JoystickButton(operatorController, 4);
  Button operatorButtonLeftBumper = new JoystickButton(operatorController, 5);
  Button operatorButtonRightBumper = new JoystickButton(operatorController, 6);
  Button operatorButtonLeftStick = new JoystickButton(operatorController, 7);
  Button operatorButtonRightStick = new JoystickButton(operatorController, 8);
  Button operatorBouchPad = new JoystickButton(operatorController, 14);
  Button operatorButtonOptions = new JoystickButton(operatorController, 10);
  Button operatorButtonShare = new JoystickButton(operatorController, 9);
  Button operatorPlayStation = new JoystickButton(operatorController, 13);
  Button operatorLeftButton = new JoystickButton(operatorController, 11);
  Button operatorRightButton = new JoystickButton(operatorController, 12);
  // Button operatorDPadUp = new JoystickButton(operatorController, 0);
  Button operatorDPadRight = new JoystickButton(operatorController, 90);
  Button operatorDPadDown = new JoystickButton(operatorController, 180);
  Button operatorDPadLeft = new JoystickButton(operatorController, 270);
  Button operatorRightTrigger = new JoystickButton(operatorController, 8);
  Button operatorLeftTrigger = new JoystickButton(operatorController, 7);

  public OI() {
    // Start Driver controls
    buttonCircle.whileHeld(new IntakeRun(-0.7));
    buttonX.whileHeld(new IntakeRun(0.7));
    buttonSquare.whileHeld(new IntakeDrop(Enums.IntakeDirection.FORWARD));
    buttonTriangle.whileHeld(new IntakeDrop(Enums.IntakeDirection.REVERSE));

    buttonOptions.toggleWhenPressed(new AutoMoveRotate(720, 0.7));
    buttonShare.toggleWhenPressed(new Slalomn());
    // end driver controls

    // Start Nicks operator controls
    operatorButtonTriangle.whileHeld(new ShooterAim(-0.7));
    operatorButtonSquare.whileHeld(new ShooterAim(0.7));
    operatorButtonCircle.whileHeld(new ShooterShoot(-0.3));
    operatorButtonX.whileHeld(new ShooterShoot(0.8));

    operatorButtonLeftBumper.whileHeld(new Belt(1));
    operatorButtonRightBumper.whileHeld(new Belt(-1));
    operatorRightTrigger.whileHeld(new ShooterShoot(0.8));
    operatorButtonShare.whileHeld(new LimeLightShooterAlign(1, 0));
    operatorLeftButton.whileHeld(new LimeLightShooterAlignClose());
    operatorButtonOptions.whileHeld(new LimeLightDriveAlign(DirectionEnum.STOP));
    operatorLeftTrigger.whileHeld(new ShooterShoot(0.95));
    operatorPlayStation.whileHeld(new IntakeBall());
    operatorRightButton.whileHeld(new ShootSequence());

    // End Nicks operator controls
  }

  public double GetDriverRawStickAxis(int stickAxis) {
    return driverController.getRawAxis(stickAxis);
  }

  public double GetDriverRawTriggerAxis(int triggerAxis) {
    if (driverController.getRawAxis(triggerAxis) < 0) {
      return 0;
    } else {
      return driverController.getRawAxis(triggerAxis);
    }
  }

  public double GetOperatorRawStickAxis(int stickAxis) {
    return operatorController.getRawAxis(stickAxis);
  }

}
// Sd changes needed in OI, ShootSequence, and Auto
