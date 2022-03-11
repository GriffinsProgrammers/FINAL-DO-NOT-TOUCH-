// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutomatedCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.LowerCatapultCommand;
import frc.robot.commands.ReleaseCatapultCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.AutomatedCommands.*;
import frc.robot.commands.*;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Sixpointer extends SequentialCommandGroup {
  /** Creates a new autonomous command sequence. */
  /*
  move, shoot, move, intake, move shoot, */
  public Gyro gyroAuto;

  public Sixpointer(
      SwerveRotaters rotators,
      SwerveSpinners spinners,
      Gyro gyro,
      Catapult catapult,
      Intake intake) {
    // This is the sequential commands within our autonomous sequence
    gyroAuto = gyro;
    addCommands(
        new SequentialCommandGroup(
            new IntakeAuto(intake, true),
            new LowerCatapult(catapult),
            new Rotate(rotators, spinners, gyroAuto, 180), //135 or 225
            new ReleaseCatapultCommand(catapult),
            new MoveForward(rotators, spinners, 1, 1)));
  }
}
