import pt.iscte.greyditor.Greyditor;

void main() {
    Greyditor configuration = new Greyditor("VintageEditor");

    // Phase 1
    configuration.addFilter("Brightness", Filters::brightness, -255, 255);
    configuration.addFilter("Invert", Filters::contrast, 0, 100);
    configuration.addEffect("Horizontal Flip", Effect::horizontalFlip);
    configuration.addEffect("Vertical Flip", Effect::verticalFlip);
    configuration.addFilter("Grain", Filters::grain, 0, 150);
    configuration.addEffect("Margin", Effect::margin);
    configuration.addEffect("Vignette", Effect::vignette, 0, 100);

    // Phase 2
    configuration.addOperation("Crop", Operations::crop);
    configuration.addOperation("Expand", Operations::expand);

    configuration.open("monalisa.jpg");
}