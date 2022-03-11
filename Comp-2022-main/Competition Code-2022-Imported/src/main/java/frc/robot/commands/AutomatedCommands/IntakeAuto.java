package frc.robot.commands.AutomatedCommands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeAuto extends CommandBase {
  boolean run;
  Intake intake;
  private long time;
  private double timer;

  public IntakeAuto(Intake intake, boolean run) {
    this.intake = intake;
    this.run = run;

    addRequirements(intake);
  }

  public void initialize() {
    timer = System.currentTimeMillis();
    if (run) {
      intake.pistonForward();
      // intake.intake();
    } else if (!run) {
      intake.pistonReverse();
      intake.off();
    }
  }

  public void execute() {}

  public void end(boolean interrupted) {
  }

  public boolean isFinished() {
    return (System.currentTimeMillis() - timer > 2500);
  }
}
