// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoMoveAngleCorrect;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Bounce extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.6;
  private static double delayTime = 0.5;
  /** Creates a new Boucnce. */
  public Bounce() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //1
      new AutoMoveDistance(45, distanceSpeed), 
      new WaitCommand(delayTime), 
      new AutoMoveRotate(-90, rotateSpeed),
      new WaitCommand(delayTime),
      //2
      new AutoMoveDistance(51, distanceSpeed), 
      new WaitCommand(delayTime), 
      //3
      new AutoMoveDistance(-35, distanceSpeed),
      new WaitCommand(delayTime),   
      new AutoMoveAngleCorrect(245, 0.4),
      new WaitCommand(0.3),
      //4
      new AutoMoveDistance(-153, distanceSpeed),
      new WaitCommand(delayTime),
      new AutoMoveAngleCorrect(276, 0.4),
      new WaitCommand(0.3),
      //5
      new AutoMoveDistance(163, distanceSpeed),
      new WaitCommand(delayTime),
      //6
      new AutoMoveDistance(-108, distanceSpeed),
      new WaitCommand(delayTime),
      new AutoMoveAngleCorrect(355, 0.4),
      new WaitCommand(0.3),
      //7 
      new AutoMoveDistance(90, distanceSpeed),
      new WaitCommand(delayTime),
      new AutoMoveAngleCorrect(270, 0.4),
      new WaitCommand(delayTime),
      //8
      new AutoMoveDistance(133, distanceSpeed),
      new WaitCommand(delayTime),
      //9
      new AutoMoveDistance(-62, distanceSpeed),
      new WaitCommand(delayTime),
      new AutoMoveAngleCorrect(0, 0.4),
      new WaitCommand(0.3),
      //10
      new AutoMoveDistance(80, distanceSpeed)

    );
  }
}
