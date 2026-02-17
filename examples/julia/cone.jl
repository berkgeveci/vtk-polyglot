using PyCall

vtk = pyimport("vtkmodules.vtkFiltersSources")
vtkRendering = pyimport("vtkmodules.vtkRenderingCore")
pyimport("vtkmodules.vtkRenderingOpenGL2")
pyimport("vtkmodules.vtkInteractionStyle")

cone = vtk.vtkConeSource()
cone.SetResolution(8)

mapper = vtkRendering.vtkPolyDataMapper()
mapper.SetInputConnection(cone.GetOutputPort())

actor = vtkRendering.vtkActor()
actor.SetMapper(mapper)

renderer = vtkRendering.vtkRenderer()
renderer.AddActor(actor)
renderer.SetBackground(0.2, 0.3, 0.4)

window = vtkRendering.vtkRenderWindow()
window.AddRenderer(renderer)
window.SetSize(640, 480)

interactor = vtkRendering.vtkRenderWindowInteractor()
interactor.SetRenderWindow(window)

window.Render()
interactor.Start()
