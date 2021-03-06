// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoMoveAngleCorrect;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;
import frc.robot.commands.WaitAndDoNothing;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Bounce extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.6;
  private static double delayTime = 0.3;
  /** Creates a new Boucnce. */
  public Bounce() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //1
      new AutoMoveDistance(48, distanceSpeed), 
      new WaitAndDoNothing(delayTime), 
      new AutoMoveRotate(-90, rotateSpeed),
      new WaitAndDoNothing(delayTime),
      //2
      new AutoMoveDistance(51, distanceSpeed), 
      new WaitAndDoNothing(delayTime), 
      //3
      new AutoMoveDistance(-35, distanceSpeed),
      new WaitAndDoNothing(delayTime),   
      new AutoMoveRotate(-15, 0.35),
      new WaitAndDoNothing(0.3),
      //4
      new AutoMoveDistance(-153, distanceSpeed),
      new WaitAndDoNothing(delayTime),
      new AutoMoveRotate(15, 0.35),
      new WaitAndDoNothing(0.3),
      new AutoMoveAngleCorrect(270, 0.3),
      new WaitAndDoNothing(0.3),
      //5
      new AutoMoveDistance(163, distanceSpeed),
      new WaitAndDoNothing(delayTime),
      //6
      new AutoMoveDistance(-118, distanceSpeed),
      new WaitAndDoNothing(delayTime),
      new AutoMoveRotate(80, 0.35),
      new WaitAndDoNothing(0.3),
      new AutoMoveAngleCorrect(0, 0.35),
      new WaitAndDoNothing(0.3),
      //7 
      new AutoMoveDistance(90, distanceSpeed),
      new WaitAndDoNothing(delayTime),
      new AutoMoveRotate(-85, 0.35),
      new WaitAndDoNothing(delayTime),
      new AutoMoveAngleCorrect(270, 0.35),
      new WaitAndDoNothing(0.3),
      //8
      new AutoMoveDistance(117, distanceSpeed),
      new WaitAndDoNothing(delayTime),
      //9
      new AutoMoveDistance(-62, distanceSpeed),
      new WaitAndDoNothing(delayTime),
      new AutoMoveRotate(70, rotateSpeed),
      new WaitAndDoNothing(0.3),
      //10
      new AutoMoveDistance(25, distanceSpeed)

    );
  }
}
