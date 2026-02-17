cmake_minimum_required(VERSION 3.12)
project(VTKCone)

find_package(VTK REQUIRED
  COMPONENTS
    FiltersSources
    RenderingCore
    RenderingOpenGL2
    InteractionStyle
)

add_executable(cone cone.cpp)
target_link_libraries(cone PRIVATE ${VTK_LIBRARIES})
vtk_module_autoinit(TARGETS cone MODULES ${VTK_LIBRARIES})
